package lab4_1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AdvancedSearchBoundary {
    private AdvancedSearchController controller = new AdvancedSearchController();
    public static boolean flag=false;
    public List<Integer> displayForm() {
        System.out.println("==== 西南科技大学图书馆高级搜索 ====");
        System.out.println("1. 添加搜索条件");
        System.out.println("2. 设置文档类型");
        System.out.println("3. 设置出版日期范围");
        System.out.println("4. 设置高级选项");
        System.out.println("5. 结束");
        System.out.print("请选择操作，操作1可以输入两次，其余操作只能输入一次，最少输入一个操作（请用空格分隔，最多5个操作）：");

        Scanner scanner = new Scanner(System.in);
        List<Integer> choice = new ArrayList<>();
        int addConditionCount = 0;
        boolean[] operated = new boolean[7]; // 1-6号操作，operated[1]~operated[6]有效

        String line = scanner.nextLine().trim();
        while (line.isEmpty()) {
            System.out.print("请至少输入一个操作编号：");
            line = scanner.nextLine().trim();
        }

        String[] tokens = line.split("\\s+");
        if (tokens.length > 5) {
            System.out.println("最多只能输入5个操作，将只取前5个。");
        }

        for (int i = 0; i < tokens.length && choice.size() < 5; i++) {
            String token = tokens[i];
            int choiceInt;
            try {
                choiceInt = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("无效输入：" + token + "，请确保输入的是数字。");
                continue;
            }
            if (choiceInt < 1 || choiceInt > 5) {
                System.out.println("请输入1-5之间的操作编号，跳过：" + choiceInt);
                continue;
            }
            if (choiceInt == 1) {
                if (addConditionCount >= 2) {
                    flag=true;
                    System.out.println("操作1（添加搜索条件）最多只能输入两次，跳过多余的。");
                    continue;
                }
                addConditionCount++;
                choice.add(choiceInt);
            } else {
                if (operated[choiceInt]) {
                    System.out.println("操作" + choiceInt + "只能输入一次，跳过多余的。");
                    continue;
                }
                operated[choiceInt] = true;
                choice.add(choiceInt);
            }
        }

        if (choice.isEmpty()) {
            System.out.println("至少需要选择一个操作，请重新输入。");
            displayForm();
            return null;
        }

        System.out.println("已选择操作：" + choice);
        return choice;
    }
    public AdvancedSearchForm getUserInput(AdvancedSearchForm form ) {
        Scanner scanner = new Scanner(System.in);
//        AdvancedSearchForm form = new AdvancedSearchForm();

        System.out.print("请输入文档类型 (BOOK, JOURNAL, THESIS等): ");
        String docTypeStr = scanner.nextLine();
        form.setDocumentType(DocumentType.valueOf(docTypeStr.toUpperCase()));

        return form;
    }
    public void get_num(List<Integer> choices,AdvancedSearchForm form){
        for (Integer choice : choices){
            switch (choice)
            {
                case 1:
                    addSearchConditions(form);
                    break;
                case 2:
                    getUserInput(form);
                    break;
                case 3:
                    addDate(form);
                    break;
                case 4:
                    setAdvancedOptions( form);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }

    }
    private void addSearchConditions(AdvancedSearchForm form) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("--- 添加搜索条件 ---");

            System.out.println("可用字段: " + Arrays.toString(Field.values()));
            System.out.print("选择字段: ");
            Field field = Field.valueOf(scanner.nextLine().toUpperCase());


            System.out.println("可用模式: " + Arrays.toString(Mode.values()));
            System.out.print("选择模式: ");
            Mode mode = Mode.valueOf(scanner.nextLine().toUpperCase());


            if(flag){
                System.out.println("可用关系: " + Arrays.toString(Relation.values()));
                System.out.print("选择关系: ");
                Relation relation = Relation.valueOf(scanner.nextLine().toUpperCase());
            }
            System.out.print("输入值: ");
            String value = scanner.nextLine();
            System.out.println("已添加搜索条件: " + field + ", " + mode + ", " + value);

            SearchCondition condition = new SearchCondition(field,  value, mode);
            form.addCondition(condition);

    }

    private void setAdvancedOptions(AdvancedSearchForm form) {
        AdvancedOptions options = form.getAdvancedOptions();
        Scanner scanner=new Scanner(System.in);
        System.out.println("--- 设置高级选项 ---");



        System.out.println("重要收录: " + Arrays.toString(Source.values()));
        System.out.print("添加重要收录? (y/n): ");
        if ("y".equalsIgnoreCase(scanner.nextLine())) {
            addSources(scanner, options);
        }

        System.out.println("语言: " + Arrays.toString(Language.values()));
        System.out.print("添加语言限制? (y/n): ");
        if ("y".equalsIgnoreCase(scanner.nextLine())) {
            addLanguages(scanner, options);
        }

        System.out.println("载体: " + Arrays.toString(Carrier.values()));
        System.out.print("添加载体限制? (y/n): ");
        if ("y".equalsIgnoreCase(scanner.nextLine())) {
            addCarriers(scanner, options);
        }
        System.out.print("启用智能扩展? (y/n): ");
        options.setIntelligentExpansion("y".equalsIgnoreCase(scanner.nextLine()));
    }

    private void addSources(Scanner scanner, AdvancedOptions options) {
        while (true) {
            System.out.print("输入来源名称: ");
            String sourceStr = scanner.nextLine();
            options.addSource(Source.valueOf(sourceStr.toUpperCase()));

            System.out.print("添加更多来源? (y/n): ");
            if (!"y".equalsIgnoreCase(scanner.nextLine())) {
                break;
            }
        }
    }

    private void addLanguages(Scanner scanner, AdvancedOptions options) {
        while (true) {
            System.out.print("输入语言: ");
            String langStr = scanner.nextLine();
            options.addLanguage(Language.valueOf(langStr.toUpperCase()));

            System.out.print("添加更多语言? (y/n): ");
            if (!"y".equalsIgnoreCase(scanner.nextLine())) {
                break;
            }
        }
    }
    public Date StringToDate(String s) {
        // 定义格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

// 转换为 LocalDate
        LocalDate localDate  = LocalDate.parse(s, formatter);
        Date d = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(d);
        return d;
    }
    private void addDate( AdvancedSearchForm form){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入开始出版时间: ");
        String  publishDateStart = scanner.nextLine();
        System.out.println("请输入结束出版时间:");
        String publishDateEnd = scanner.nextLine();
        form.setPublishDateStart(StringToDate(publishDateStart));
        form.setPublishDateEnd(StringToDate(publishDateEnd));
    }

    private void addCarriers(Scanner scanner, AdvancedOptions options) {
        while (true) {
            System.out.print("输入载体: ");
            String carrierStr = scanner.nextLine();
            options.addCarrier(Carrier.valueOf(carrierStr.toUpperCase()));

            System.out.print("添加更多载体? (y/n): ");
            if (!"y".equalsIgnoreCase(scanner.nextLine())) {
                break;
            }
        }
    }

    public void showResults(SearchResult results) {
        System.out.println("\n==== 搜索结果 ====");
        System.out.println("找到 " + results.getTotalCount() + " 条记录");

        for (Book book : results.getBooks()) {
            System.out.println(book);
            // 西南科技大学特色：显示馆藏状态
            System.out.println("  状态: " + book.getStatus().getStatus());
        }
    }
}
