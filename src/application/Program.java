package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import models.dao.DaoFactory;
import models.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 01: Seller FindById ===");
        Seller seller = sellerDao.findById(3);      
        System.out.println(seller);
        
        System.out.println();

        System.out.println("=== Teste 02: Seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for(Seller obj: sellers){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== Teste 03: Seller findAll ===");
        sellers = sellerDao.findAll();
        for(Seller obj: sellers){
            System.out.println(obj);
        }

        System.out.println();

        System.out.println("=== Teste 04: Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 3000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Foi inserido um novo ID: " + newSeller.getId());

        System.out.println();

        System.out.println("=== Teste 05: Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marcia Green");
        sellerDao.update(seller);
        System.out.println("Update concluído!");

        System.out.println();

        System.out.print("Entre com o ID que deseja deletar: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("ID excluída com sucesso!");
        
    }
}
