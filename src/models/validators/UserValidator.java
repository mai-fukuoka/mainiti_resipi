package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
    public static List<String> validate(User u,Boolean user_idDuplicateCheckFlag,Boolean passwordCheckFlag){
        List<String>errors=new ArrayList<String>();

        String user_id_error=validateUser_id(u.getUser_id(),user_idDuplicateCheckFlag);
        if(!user_id_error.equals("")){
            errors.add(user_id_error);
        }

        String name_error=validateName(u.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }
        String password_error=validatePassword(u.getPassword(),passwordCheckFlag);
        if(!password_error.equals("")){
            errors.add(password_error);

        }
        return errors;
    }

    //ユーザーID
    private static String validateUser_id(String user_id,Boolean user_idDuplicateCheckFlag){
        if(user_id==null ||user_id.equals("")){
            return "ユーザーIDを入力してください。";
        }
        // すでに登録されているIDとの重複チェック
        if(user_idDuplicateCheckFlag){
            EntityManager em=DBUtil.createEntityManager();
            long users_count=(long)em.createNamedQuery("checkRegisteredUser_id",Long.class)
                    .setParameter("user_id",user_id).getSingleResult();
            em.close();
            if(users_count>0){
                return "入力されたユーザーIDはすでに存在しています。";
            }

        }
        return "";
    }

    //氏名の必須入力チェック
    private static String validateName(String name){
        if(name==null || name.equals("")){
            return "氏名を入力してください。";

        }
        return "";

    }

    //パスワードの必須入力チェック
    private static String validatePassword(String password,Boolean passwordCheckFlag) {
        if(passwordCheckFlag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";

    }

}
