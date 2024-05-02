package warehouse;

import reporting.Reporting;

public interface Place {

    void addReporting(Reporting<?> reporting);
    void showReporting();

}
