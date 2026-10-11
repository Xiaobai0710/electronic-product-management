import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product>products=new ArrayList<>();
    static Scanner scanner=new Scanner(System.in);


    static {
        products.add(new Product(1, "手机", 2999, 10, "数码"));
        products.add(new Product(2, "笔记本电脑", 5999, 5, "数码"));
        products.add(new Product(3, "打印机", 899, 3, "办公"));
        products.add(new Product(4, "键盘", 199, 20, "配件"));
        products.add(new Product(5, "鼠标", 99, 50, "配件"));

    }

    public  static void main(String[] args){
        while (true){
            printMenu();
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:addProduct();break;
                case 2:deleteProduct();break;
                case 3:updateProduct();break;
                case 4:listProduct();break;
                case 5:searchProduct();break;
                case 0:
                    System.out.println("退出");
                    return;
                default:
                    System.out.println("无效");

            }
        }

    }
    static void printMenu() {
        System.out.println("\n电子商品数据管理系统");
        System.out.println("1. 添加商品");
        System.out.println("2. 删除商品");
        System.out.println("3. 修改商品");
        System.out.println("4. 查看所有商品");
        System.out.println("5. 按名称搜索");
        System.out.println("0. 退出");
        System.out.print("请选择：");
    }


    static void  printUpdatanume(){
        System.out.println("\n需要修改的项目：");
        System.out.println("1. 名称");
        System.out.println("2. 价格");
        System.out.println("3. 库存");
        System.out.println("4. 分类");
        System.out.println("0. 退出");
        System.out.print("请选择：");
    }





    static void addProduct(){
        System.out.print("输入id");
        int id=scanner.nextInt();
        scanner.nextLine();// 这里会直接读到空字符串
        System.out.print("输入名称");
        String name=scanner.nextLine();
        System.out.print("输入价格");
        double price=scanner.nextDouble();
        System.out.print("输入库存");
        int stock=scanner.nextInt();
        scanner.nextLine();
        System.out.print("输入分类");
        String category=scanner.nextLine();
        products.add(new Product(id,name,price,stock,category));
        System.out.print("添加成功");

    }

    static void deleteProduct(){
        System.out.print("输入想删除的产品id：");
        int id=scanner.nextInt();
        scanner.nextLine();
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                products.remove(i);
                System.out.print("删除成功");
                return;
            }
        }
        System.out.print("未找到");
    }


    static void updateProduct(){
        System.out.print("输入修改id");
        int id=scanner.nextInt();
        scanner.nextLine();
        for (Product p:products){
            if(p.getId()==id){

                    printUpdatanume();
                    System.out.print("输入需要修改的项目：");
                    int choice=scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){
                        case 1:{
                            System.out.print("输入新名称：");
                            String name=scanner.nextLine();
                            p.setName(name);
                            System.out.println("修改成功");
                            break;
                        }
                        case 2:{
                            System.out.print("输入新价格");
                            double price=scanner.nextDouble();
                            p.setPrice(price);
                            System.out.println("修改成功");
                            break;
                        }
                        case 3:{
                            System.out.print("输入新库存");
                            int stock=scanner.nextInt();
                            p.setStock(stock);
                            System.out.println("修改成功");
                            break;
                        }
                        case 4:{
                            System.out.print("输入分类");
                            String category=scanner.nextLine();
                            p.setCategory(category);
                            System.out.println("修改成功");
                            break;
                        }
                        case 0:
                            System.out.print("退出");
                            return;
                        default:
                            System.out.println("无效");




                }

                return;
            }


        }
        System.out.println("未找到该商品");
    }


    static void listProduct(){
        if(products.isEmpty()){
            System.out.println("暂无商品");
            return;
        }
        for (Product p:products){
            System.out.println(p);
        }
    }


    static void searchProduct(){
        System.out.print("输入关键词：");
        String keyword=scanner.nextLine();
        boolean found=false ;
        for (Product p:products){
            if (p.getName().contains(keyword)){
                System.out.println(p);
                found=true;

            }
        }
        if(!found){
            System.out.println("未找到匹配商品");
        }
    }





























}