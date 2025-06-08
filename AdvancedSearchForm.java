package lab4_1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvancedSearchForm {

    private List<SearchCondition> conditions = new ArrayList<>();//搜索条件
    private DocumentType documentType;//文档类型
    private Date publishDateStart;//出版日期开始
    private Date publishDateEnd;//出版日期结束
    private AdvancedOptions advancedOptions = new AdvancedOptions();//高级选项
    public AdvancedSearchForm() {
        // 默认构造函数
//        conditions=null;
        documentType = null;
        publishDateStart = null;
        publishDateEnd = null;
        advancedOptions = null;
    }
    // 操作方法
    public void addCondition(SearchCondition condition) {
        conditions.add(condition);
    }

    public void removeCondition(SearchCondition condition) {
        conditions.remove(condition);
    }

    public void reset() {
        conditions.clear();
        publishDateStart = null;
        publishDateEnd = null;
        advancedOptions = new AdvancedOptions();
    }

    public void save() {
        // 实现保存搜索条件的逻辑
        System.out.println("保存搜索条件: " + this);
    }

    // Getters and Setters
    public List<SearchCondition> getConditions() { return conditions; }
    public void setConditions(List<SearchCondition> conditions) { this.conditions = conditions; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }

    public Date getPublishDateStart() { return publishDateStart; }
    public void setPublishDateStart(Date publishDateStart) { this.publishDateStart = publishDateStart; }

    public Date getPublishDateEnd() { return publishDateEnd; }
    public void setPublishDateEnd(Date publishDateEnd) { this.publishDateEnd = publishDateEnd; }

    public AdvancedOptions getAdvancedOptions() { return advancedOptions; }
    public void setAdvancedOptions(AdvancedOptions advancedOptions) { this.advancedOptions = advancedOptions; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("文档类型: ").append(documentType).append("\n");
        sb.append("出版日期范围: ").append(publishDateStart).append(" 至 ").append(publishDateEnd).append("\n");
        sb.append("搜索条件:\n");
        for (SearchCondition condition : conditions) {
            sb.append("  - ").append(condition).append("\n");
        }
        sb.append("高级选项: ").append(advancedOptions.isIntelligentExpansion() ? "智能扩展开启" : "智能扩展关闭");
        return sb.toString();
    }
}
