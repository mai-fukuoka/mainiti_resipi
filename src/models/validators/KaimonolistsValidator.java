package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Kaimonolist;

public class KaimonolistsValidator {


    public static List<String>validate(Kaimonolist k){
        List<String> errors=new ArrayList<String>();

        String ingredient_error=validateIngredient(k.getIngredient());
        if(!ingredient_error.equals("")){
            errors.add(ingredient_error);
        }

        return errors;
    }
        private static String validateIngredient(String ingredient) {
            if(ingredient==null || ingredient.equals("")){
                return "買うものを入力してください";
            }
            return "";
        }
}
