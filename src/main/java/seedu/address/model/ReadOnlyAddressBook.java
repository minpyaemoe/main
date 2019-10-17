package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.spending.Spending;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Spending> getSpendingList();

    /**
     * Returns the Budget of the Address Book.
     */
    Budget getBudget();
}
