class IB_Atoi{
    public static void main(String[] args) {
        
    }
    public int atoi(final String A) {
        
        StringBuilder sb = new StringBuilder(A.trim());
        StringBuilder result = new StringBuilder("");
        boolean seenPlusOrMinus = false;
        char plusOrMinus = '+';
        int startingIndex = 0;
        if(sb.charAt(0)=='+'||sb.charAt(0)=='-'){
            plusOrMinus = sb.charAt(0);
            seenPlusOrMinus = true;
            startingIndex = 1;
        }
        for(int i=startingIndex;i<sb.length();i++){
                if(sb.charAt(i)-'1'>=0 && sb.charAt(i)-'1'<=9){
                    result.append(sb.charAt(i));
                }else{
                    break;
                }
        }

        while(result.length()>0){
            if(result.charAt(0)=='0'){
                result.deleteCharAt(0);
            }else{
                break;
            }
        }
        long resultInteger = 0;
        if(result.length()==0){
            return 0;
        }
        
        if(seenPlusOrMinus){
            switch(plusOrMinus){
                case '+':
                        if(result.length()>10){
                            return Integer.MAX_VALUE;
                        }else{
                            resultInteger = Long.parseLong(result.toString());
                            if(resultInteger - Integer.MAX_VALUE >0){
                                return Integer.MAX_VALUE;
                            }
                        }
                case '-':
                result.insert(0, '-');
                if(result.length()>11){
                    return Integer.MIN_VALUE;
                }else{
                    resultInteger = Long.parseLong(result.toString());
                    if(resultInteger - Integer.MIN_VALUE < 0){
                        return Integer.MIN_VALUE;
                    }
                }
            }
        }else{
            if(result.length()>10){
                return Integer.MAX_VALUE;
            }else{
                resultInteger = Long.parseLong(result.toString());
                if(resultInteger - Integer.MAX_VALUE >0){
                    return Integer.MAX_VALUE;
                }
            }
        }
        return (int)resultInteger;
    }
}