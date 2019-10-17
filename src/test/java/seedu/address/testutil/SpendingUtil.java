package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_COST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditSpendingDescriptor;
import seedu.address.model.spending.Spending;
import seedu.address.model.tag.Tag;

/**
 * A utility class for Spending.
 */
public class SpendingUtil {

    /**
     * Returns an add command string for adding the {@code Spending}.
     */
    public static String getAddCommand(Spending spending) {
        return AddCommand.COMMAND_WORD + " " + getSpendingDetails(spending);
    }

    /**
     * Returns the part of command string for the given {@code Spending}'s details.
     */
    public static String getSpendingDetails(Spending spending) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + spending.getName().fullName + " ");
        sb.append(PREFIX_DATE + spending.getDate().value + " ");
        sb.append(PREFIX_REMARK + spending.getRemark().value + " ");
        sb.append(PREFIX_COST + spending.getCost().value + " ");
        spending.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditSpendingDescriptor}'s details.
     */
    public static String getEditSpendingDescriptorDetails(EditSpendingDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getDate().ifPresent(date -> sb.append(PREFIX_DATE).append(date.value).append(" "));
        descriptor.getRemark().ifPresent(remark -> sb.append(PREFIX_REMARK).append(remark.value).append(" "));
        descriptor.getCost().ifPresent(cost -> sb.append(PREFIX_COST).append(cost.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
