package com.tyss.fms.controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.tyss.fms.dto.ContractBean;
import com.tyss.fms.dto.CustomerBean;
import com.tyss.fms.dto.LandBean;
import com.tyss.fms.dto.ProductBean;
import com.tyss.fms.factory.ForestryManagementSystemFactory;
import com.tyss.fms.services.ContractServices;
import com.tyss.fms.services.CustomerServices;
import com.tyss.fms.services.LandServices;
import com.tyss.fms.services.ProductServices;

public class App {
	static Scanner sc = new Scanner(System.in);
	static CustomerBean customer = null;
	static ContractBean contract = null;
	static ProductBean product = null;
	static LandBean landBean = null;

	public static void main(String[] args) {
		CustomerServices customerServices = ForestryManagementSystemFactory.instanceOfCustomerServices();
		ContractServices contractServices = ForestryManagementSystemFactory.instanceOfContractServices();
		ProductServices productServices = ForestryManagementSystemFactory.instanceOfProductServies();
		LandServices landServices= ForestryManagementSystemFactory.instanceOfLandServices();
		List<CustomerBean> customerList = null;
		List<ContractBean> contractList = null;
		List<ProductBean> productList = null;
		Set<LandBean> landSet=null;

		while (true) {
			int customerChoice;
			int contractChoice;
			int dashBoardChoice;
			int productChoice;
			int landChoice;
			dashBoardChoice = Menu.dashBoardMenu();
			switch (dashBoardChoice) {
			case 1:
				while (true) {
					customerChoice = Menu.customerMenu();
					switch (customerChoice) {
					/*---------------------Manage Customer------------------*/
					case 1:
						if (customerServices.addCustomer(Menu.readCustomerDetails(customer))) {
							System.out.println("New Customer has been added");
						} else {
							System.err.println("Duplicate Customer Id can not be added");
						}
						break;

					case 2:
						System.out.println("Please enter Customer");
						String custId = sc.nextLine();
						System.out.println("Please enter new Email Id to be updated");
						String email = sc.nextLine();
						if (customerServices.modifyCustomer(custId, email)) {
							System.out.println(
									"Customer with ID: " + custId + " has been updated with new email: " + email);
						} else {
							System.out.println("Customer with ID: " + custId + " is not present in database");
						}
						break;

					case 3:
						System.out.println("Please enter Customer Id to be deleted");
						custId = sc.nextLine();
						if (customerServices.deleteCustomer(custId)) {
							System.out.println("Customer with ID: " + custId + " has been deleted");
						} else {
							System.out.println("Customer with ID: " + custId + " is not present in database");
						}

						break;

					case 4:
						customerList = customerServices.getAllCustomer();

						if (customerList.size() > 0) {
							for (CustomerBean cust : customerList) {
								System.out.println(cust);
							}
						} else {
							System.out.println("No Database for customers, please add new customer");
						}
						break;

					case 5: // To be added
						break;

					case 6:
						main(args);
						break;

					case 7:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}

			case 2:
				/*-------------------Contract---------------------------*/
				while (true) {
					contractChoice = Menu.contractMenu();
					switch (contractChoice) {
					case 1:

						if (contractServices.addContract(Menu.readContractDetails(contract))) {
							System.out.println("New Contract has been added");
						} else {
							System.err.println("Duplicate Contract Id can not be added");
						}
						break;

					case 2:
						System.out.println("Please enter Contract Id to be deleted");
						String contractId = sc.nextLine();
						if (contractServices.deleteContract(contractId)) {
							System.out.println("Contract with ID: " + contractId + " has been deleted");
						} else {
							System.out.println("Contract with ID: " + contractId + " is not present in database");
						}

						break;

					case 3:
						contractList = contractServices.getAllContract();

						if (contractList.size() > 0) {
							for (ContractBean contract : contractList) {
								System.out.println(contract);
							}
						} else {
							System.out.println("No Database for contracts, please add new contract");
						}
						break;

					case 4: // To be added
						break;

					case 5:
						main(args);
						break;

					case 6:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}

			case 3:
				/*-------------------Product---------------------------*/
				while (true) {
					productChoice = Menu.productMenu();
					switch (productChoice) {
					case 1:
						product = new ProductBean();
						System.out.println("Please enter Product Id");
						String productId = sc.nextLine();

						if (productServices.searchProduct(productId)) {
							productServices.updateQuantity(productId);
							System.out.println("Product already exists, hence quantity has been increamented");
						} else {
							product.setProductId(productId);
							System.out.println("Please enter Product Name");
							product.setProductName(sc.nextLine());
							System.out.println("Please enter Product Quantity");
							product.setProductQuantity(sc.nextInt());
							sc.nextLine();
							System.out.println("Please enter Product Price");
							product.setProductPrice(sc.nextDouble());
							sc.nextLine();
							System.out.println("Please enter Product Comments");
							product.setProductComments(sc.nextLine());
							productServices.addProduct(product);
							System.out.println("New Product has been added");
						}
						break;

					case 2:
						System.out.println("Please enter Product Id to be deleted");
						productId = sc.nextLine();
						if (productServices.deleteProduct(productId)) {
							System.out.println("Product with ID: " + productId + " has been deleted");
						} else {
							System.out.println("Product with ID: " + productId + " is not present in database");
						}
						break;

					case 3:
						productList = productServices.getAllProduct();

						if (productList.size() > 0) {
							for (ProductBean product : productList) {
								System.out.println(product);
							}
						} else {
							System.out.println("No Database for Products, please add new product");
						}
						break;

					case 4:
						System.out.println("Please enter Product Id to be searched");
						productId = sc.nextLine();

						if (productServices.searchProduct(productId)) {
							System.out.println("Product found");
						} else {
							System.out.println("Product Not Found");
						}
						break;

					case 5:
						main(args);
						break;

					case 6:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}

			case 4: /*-------------------Land Records---------------------------*/
				while (true) {
					landChoice = Menu.landMenu();
					switch (landChoice) {
					case 1:

						if (landServices.addLandRecord(Menu.readLandDetails(landBean))) {
							System.out.println("New Land record has been added");
						} else {
							System.err.println("Duplicate Land Id can not be added");
						}
						break;

						
					case 2: 
						System.out.println("Please enter Land Id");
						sc.nextLine();
						String landId = sc.nextLine();
						System.out.println("Please enter new Land Tax to be updated");
						double landTax = sc.nextDouble();
						if (landServices.updateLandRecord(landId, landTax)) 
						{
							System.out.println(
									"Customer with ID: " + landId + " has been updated with new Tax of rupees: " + landTax);
						} else {
							System.out.println("Land with ID: " + landId + " is not present in database");
						}
						break;
						
					case 3:
						
						landSet= landServices.getAllLandRecords();

						if (landSet.size() > 0) {
							for (LandBean landBean : landSet) 
							{
								System.out.println(landBean);
							}
						} else {
							System.out.println("No Database for Land record, please add new land");
						}
						break;

					case 4: main(args);
						break;

					case 5:
						System.exit(0);
						break;

					default:
						System.out.println("Invalid Choice");
					}
				}

			case 5:
				System.exit(0);
				break;
				
			default: 
				System.out.println("Invalid Choice");

			}
		}
	}
}
