package lab4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvancedSearchUI {
    private AdvancedSearchBoundary boundary = new AdvancedSearchBoundary();

    public List<Integer> renderForm() {
        return boundary.displayForm();
    }

    public AdvancedSearchForm collectFormData(AdvancedSearchForm  form) {
        return boundary.getUserInput(form);
    }

    public void renderResults(SearchResult results) {
        boundary.showResults(results);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        AdvancedSearchController controller = new AdvancedSearchController();
        List<Integer> choices = renderForm();
        AdvancedSearchForm  form = new AdvancedSearchForm();
        boundary.get_num(choices,form);
//        collectFormData(form);
        SearchResult result = controller.handleSearchRequest(form);
        renderResults(result);
    }

    public static void main(String[] args) {
        AdvancedSearchUI ui = new AdvancedSearchUI();
        ui.run();
    }
}
