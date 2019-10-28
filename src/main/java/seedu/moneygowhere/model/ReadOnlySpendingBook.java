package seedu.moneygowhere.model;

import java.util.List;
import java.util.Set;

import javafx.collections.ObservableList;
import seedu.moneygowhere.model.budget.Budget;
import seedu.moneygowhere.model.currency.Currency;
import seedu.moneygowhere.model.reminder.Reminder;
import seedu.moneygowhere.model.spending.Spending;

/**
 * Unmodifiable view of the MoneyGoWhere list
 */
public interface ReadOnlySpendingBook {

    /**
     * Returns an unmodifiable view of the persons list.
     */
    ObservableList<Spending> getSpendingList();

    /**
     * Returns the Budget of the MoneyGoWhere list.
     */
    Budget getBudget();

    /**
     * Returns a modifiable view of the reminders list.
     */
    List<Reminder> getReminderList();

    /**
     * Returns available currencies.
     */
    Set<Currency> getCurrencies();

    /**
     * Returns the currency being used.
     */
    Currency getCurrencyInUse();
}
