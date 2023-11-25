package easy;

import java.util.HashSet;

// Unique Emails Addresses
public class UniqueEmailsAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] splitedEmail = email.split("@");
            int indexOfPlus = splitedEmail[0].indexOf("+");
            if (indexOfPlus == -1) {
                sb.append(splitedEmail[0].replace(".", ""));
            }
            else {
                sb.append(splitedEmail[0].substring(0, indexOfPlus).replace(".", ""));
            }
            sb.append("@");
            sb.append(splitedEmail[1]);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}