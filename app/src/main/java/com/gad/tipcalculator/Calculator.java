package com.gad.tipcalculator;

public class Calculator {

    public Result calc(float total, float rate) throws Exception {
        Result ret = new Result();

        if (rate < 1 || rate > 99) {
            throw new Exception("Invalid rate.");
        }
        if (total < 1) {
            throw new Exception("Invalid total.");
        }

        float subTotal = (rate / (100 + rate))/100;

        ret.setTip15(subTotal * 15 / 100);
        ret.setTip18(subTotal * 18 / 100);
        ret.setTip20(subTotal * 20 / 100);
        ret.setTot15(total + ret.getTip15());
        ret.setTot18(total + ret.getTip18());
        ret.setTot20(total + ret.getTip20());

        return ret;
    }

    public class Result {
        float tip15;
        float tip18;
        float tip20;
        float tot15;
        float tot18;
        float tot20;

        public float getTip18() {
            return tip18;
        }

        public void setTip18(float tip18) {
            this.tip18 = tip18;
        }

        public float getTip20() {
            return tip20;
        }

        public void setTip20(float tip20) {
            this.tip20 = tip20;
        }

        public float getTot15() {
            return tot15;
        }

        public void setTot15(float tot15) {
            this.tot15 = tot15;
        }

        public float getTot18() {
            return tot18;
        }

        public void setTot18(float tot18) {
            this.tot18 = tot18;
        }

        public float getTot20() {
            return tot20;
        }

        public void setTot20(float tot20) {
            this.tot20 = tot20;
        }

        public float getTip15() {
            return tip15;
        }

        public void setTip15(float tip15) {
            this.tip15 = tip15;
        }
    }
}
