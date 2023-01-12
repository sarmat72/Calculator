package ARC4kata;

public class ARC
{
    public static String calc(String input)
    {
        String result="";
        try
        {

            ARC.checkCommonErrors(input);

            switch(ARC.checkIfRoman(input))
            {
                case 0:
                {
                    result=ARC.arabicCalc(input);
                    //System.out.println("Arabian");
                    break;
                }
                case 1:
                {
                    result=ARC.romanCalc(input);
                    //System.out.println("Roman");
                    break;
                }
            }


        }
        catch (Exception a)
        {
            System.out.println(a);
        }
        return result;
    }

    static String arabicCalc(String x)
    {
        String a = "", n1 = "", n2 = "", op = "";
        try
        {

            int opC = 0;
            char s;
            for (int i = 0; i < x.length(); i++) {
                s = x.charAt(i);
                if (s == '+' || s == '-' || s == '*' || s == '/') {
                    opC++;
                    if (s == '+') {
                        op += s;
                    }
                    if (s == '-') {
                        op += s;
                    }
                    if (s == '*') {
                        op += s;
                    }
                    if (s == '/') {
                        op += s;
                    }
                }
                if (opC == 0 && s != '+' && s != '-' && s != '*' && s != '/') {
                    n1 += s;
                    //System.out.println(n1);
                }
                if (opC == 1 && s != '+' && s != '-' && s != '*' && s != '/') {
                    n2 += s;
                    //System.out.println(n2);
                }
            }

            checkArabianErrors(n1, n2);

            int result = 0;
            switch (op) {
            case "+": {
                result = Integer.valueOf(n1) + Integer.valueOf(n2);
                break;
            }
            case "-": {
                result = Integer.valueOf(n1) - Integer.valueOf(n2);
                break;
            }
            case "*": {
                result = Integer.valueOf(n1) * Integer.valueOf(n2);
                break;
            }
            case "/": {
                result = Integer.valueOf(n1) / Integer.valueOf(n2);
                break;
            }
        }
            a += result;

        }
            catch (Exception err)
            {
                System.out.println(err);
            }
        return a;
        }

    static String romanCalc(String x)
    {
            String a="", rn1="", rn2="", op="";
            int opC=0, n1=0, n2=0;
            char s;
            try
            {
                for(int i=0;i<x.length();i++)
                {
                    s=x.charAt(i);
                    if(s=='+'||s=='-'||s=='*'||s=='/')
                    {
                        opC++;
                        if(s=='+')
                        {
                            op+=s;
                        }
                        if(s=='-')
                        {
                            op+=s;
                        }
                        if(s=='*')
                        {
                            op+=s;
                        }
                        if(s=='/')
                        {
                            op+=s;
                        }
                    }
                    if(opC==0&&s!='+'&&s!='-'&&s!='*'&&s!='/')
                    {
                        rn1+=s;
                        //System.out.println(rn1);
                    }
                    if(opC==1&&s!='+'&&s!='-'&&s!='*'&&s!='/')
                    {
                        rn2+=s;
                        //System.out.println(rn2);
                    }
                }

                n1=convertRomToAr(rn1);
                n2=convertRomToAr(rn2);
                checkRomanErrors(n1,n2,op.charAt(0));
            }
            catch (Exception err)
            {
                System.out.println(err);
            }

            int result=0;
            switch (op)
            {
                case "+":
                {
                    result=n1+n2;
                    break;
                }
                case "-":
                {
                    result=n1-n2;
                    break;
                }
                case "*":
                {
                    result=n1*n2;
                    break;
                }
                case "/":
                {
                    result=n1/n2;
                    break;
                }
            }
            a=convertAr2Rom(result);
            return a;
    }

    static String convertAr2Rom(int result)
    {
        String rN="";
        for(int i=0;i<romanNumbers.length;i++)
        {
            if(result==i)
            {
                rN+=romanNumbers[i-1];
            }
        }
        return rN;
    }

    static int convertRomToAr(String n) //throws Exception
    {
        int arN=0;
        for(int i=0;i<romanNumbers.length;i++)
        {
            //System.out.print(i+" => ");
            //System.out.println(romanNumbers[i]);
            if(n.equals(romanNumbers[i]))
            {
                //System.out.println(n+" = "+romanNumbers[i]);
                arN=++i;
                //System.out.println(arN);
                return arN;
            }
        }
        //System.out.println(arN);
        return arN;
    }

    static int checkIfRoman(String x)
        {
            int a=0;
            char c=x.charAt(0);
            if(c=='I'||c=='V'||c=='X')
            {
                a++;
            }
            return a;
        }

    static void checkCommonErrors(String x) throws Exception
        {
            int a=0, operatorCounter=0, aNum=0, rNum=0;
            char s=x.charAt(0);
            if(x.length()<3)
            {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
            if(s!='I'&&s!='V'&&s!='X'&&s!='0'&&s!='1'&&s!='2'&&s!='3'&&s!='4'&&s!='5'&&s!='6'&&s!='7'&&s!='8'&&s!='9')
            {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
            for(int i=0;i<x.length();i++)
            {
                s=x.charAt(i);
                if(s!='I'&&s!='V'&&s!='X'&&s!='+'&&s!='-'&&s!='*'&&s!='/'&&
                        s!='0'&&s!='1'&&s!='2'&&s!='3'&&s!='4'&&s!='5'&&s!='6'&&s!='7'&&s!='8'&&s!='9')
                {
                    throw new Exception("throws Exception //т.к. строка не является математической операцией");
                }
                if(s=='+'||s=='-'||s=='*'||s=='/')
                {
                    operatorCounter++;
                    if(operatorCounter>1)
                    {
                        throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                }
                if(s=='I'||s=='V'||s=='X')
                {
                    rNum++;
                }
                if(s=='0'||s=='1'||s=='2'||s=='3'||s=='4'||s=='5'||s=='6'||s=='7'||s=='8'||s=='9')
                {
                    aNum++;
                }
                if(rNum>0&&aNum>0)
                {
                    throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
                }
                if(rNum>8||aNum>4)
                {
                    throw new Exception("throws Exception //unknown error, check your input");
                }
            }
        }

    static void checkArabianErrors(String x, String y) throws Exception
        {
            if (Integer.valueOf(x) < 1 || Integer.valueOf(y) < 1 || Integer.valueOf(x) > 10 || Integer.valueOf(y) > 10)
            {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - цифры от 1 до 10");
            }
        }

    static void checkRomanErrors(int n1, int n2, char op) throws Exception
        {
            if(n1<1||n1>10||n2<1||n2>10)
            {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - цифры от I до X");
            }
            if(op=='-')
            {
                if(n1-n2<1)
                {
                    throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }
            if(op=='/')
            {
                if(n1/n2<1)
                {
                    throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                }
            }
        }


        // ERRORS description:
        // 1 - throws Exception //т.к. в римской системе нет отрицательных чисел
        // 2 - throws Exception //т.к. используются одновременно разные системы счисления
        // 3 - throws Exception //т.к. строка не является математической операцией
        // 4 - throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
        // 5 - throws Exception //unknown error, check your input
        // 6 - throws Exception //т.к. формат математической операции не удовлетворяет заданию - цифры от 1 до 10
        // 7 - throws Exception //т.к. формат математической операции не удовлетворяет заданию - цифры от I до X


    static String[] romanNumbers= {"I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

}
