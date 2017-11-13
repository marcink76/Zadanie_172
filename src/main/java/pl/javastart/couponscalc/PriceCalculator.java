package pl.javastart.couponscalc;


import java.util.List;

public class PriceCalculator {

    public double calculatePrice(List<Product> products, List<Coupon> coupons) {

        double totalPrice = 0;

        for (Product product : products) {
            for (Coupon coupon : coupons) {
                if (coupon.getCategory().equals(product.getCategory())) {
                    totalPrice += product.getPrice() * (100 - coupon.getDiscountValueInPercents()) / 100;
                } else if (coupon.getCategory() == null){
                    totalPrice += product.getPrice() * (100 - coupon.getDiscountValueInPercents()) / 100;
                }
            }
        }

        double temp = Math.round(totalPrice * 100);
        totalPrice = temp / 100;
        return totalPrice;
    }
}