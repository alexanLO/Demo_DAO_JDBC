package models.dao;

import models.dao.implementacao.SellerDaoJDBC;

public class DaoFactory{ // daofactory tera functions static para instanciar o dao
    
    public static SellerDao createSellerDao (){
        return new SellerDaoJDBC(); //isso é para criar um seller sem expor a implementação, mostrando apenas a interface

    }
}