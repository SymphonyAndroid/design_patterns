package warehouse;

import reporting.Reporting;

public interface Warehouse {

    void addReporting(Reporting<?> reporting);
    void showReporting();

}
