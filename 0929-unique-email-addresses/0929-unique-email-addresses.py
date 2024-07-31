class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        unique_emails = set()
        for email in emails:
            local_name, domain_name = email.split('@')
            all_chars = list(local_name)
            new_chars = []
            for c in all_chars:
                if c != '.' and c != '+':
                    new_chars.append(c)
                if c == '+':
                    break
            unique_emails.add('@'.join([''.join(new_chars), domain_name]))
        return len(unique_emails)