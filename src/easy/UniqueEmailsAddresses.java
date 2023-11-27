package easy;

import java.util.HashSet;

// Unique Emails Addresses
public class UniqueEmailsAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] splitedEmail = email.split("@");
            String[] test = splitedEmail[0].split("\\+");
            sb.append(test[0].replace(".", ""));
            sb.append("@");
            sb.append(splitedEmail[1]);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}