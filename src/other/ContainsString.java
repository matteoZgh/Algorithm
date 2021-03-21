package other;

import java.util.Objects;

public class ContainsString {
    public boolean contains(String origin, String target) {
        if (Objects.equals(origin, target)) {
            return true;
        }

        if (origin == null || target == null) {
            return false;
        }

        char first = target.charAt(0);
        int originLen = origin.length(), targetLen = target.length(), maxLen = originLen - targetLen;

        for (int i = 0; i <= maxLen; i++){
            if (origin.charAt(i) != first) {
                while (++i <= maxLen && origin.charAt(i) != first);
            }

            if (i <= maxLen) {
                int j = i, k = 0;

                while(++j < originLen && ++k < targetLen && origin.charAt(j) == target.charAt(k));

                if (j - i == targetLen) {
                    return true;
                }
            }

        }

        return false;
    }

}
