class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        res = [str(len(s))+'#'+s for s in strs]
        return ''.join(res)
        
        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        i, res = 0, []
        while i<len(s):
            j = i
            while j<len(s) and s[j]!='#':
                j += 1
            word_len = int(s[i:j])
            res.append(s[j+1:j+1+word_len])
            i = j+1+word_len
        return res
        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))