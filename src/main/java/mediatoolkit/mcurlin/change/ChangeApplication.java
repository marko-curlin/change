package mediatoolkit.mcurlin.change;

import mediatoolkit.mcurlin.change.controller.ApiController;
import mediatoolkit.mcurlin.change.domain.expense.ExpenseRequest;
import mediatoolkit.mcurlin.change.domain.income.IncomeRequest;
import mediatoolkit.mcurlin.change.domain.interchange.InterchangeRequest;
import mediatoolkit.mcurlin.change.domain.user.UserRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ChangeApplication {

	private static final String ADD_USER = "addUser";
	private static final String GET_USER = "getUser";
	private static final String GET_ALL_USERS = "getAllUsers";
	private static final String SHOW_BALANCE = "showBalance";
	private static final String ADD_INCOME = "addIncome";
	private static final String ADD_EXPENSE = "addExpense";
	private static final String ADD_INTERCHANGE = "addInterchange";




	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ChangeApplication.class, args);

		ApiController controller = applicationContext.getBean(ApiController.class);

		Scanner sc = new Scanner(System.in);

		System.out.println("Commands: " + ADD_USER + ", " + GET_USER + ", " + GET_ALL_USERS + ", " + SHOW_BALANCE +
				", " + ADD_INCOME + ", " + ADD_EXPENSE + ", " + ADD_INTERCHANGE);

		while(sc.hasNext()){
			String command = sc.nextLine();

			if(command.equals(ADD_USER)){
				UserRequest userRequest = new UserRequest();

				System.out.print("User name> ");
				userRequest.setName(sc.nextLine());

				System.out.print("User surname> ");
				userRequest.setSurname(sc.nextLine());

				System.out.println(controller.addUser(userRequest));
			} else if(command.equals(GET_USER)){
				System.out.print("UserId> ");
				System.out.println(controller.getUser(sc.nextLong()));
			} else if (command.equals(GET_ALL_USERS) || command.equals(SHOW_BALANCE)){
				System.out.println(controller.getAllUsers());
			} else if (command.equals(ADD_INCOME)){
				IncomeRequest incomeRequest = new IncomeRequest();

				System.out.print("Income amount> ");
				incomeRequest.setAmount(sc.nextDouble());
				sc.nextLine();

				System.out.print("Income description> ");
				incomeRequest.setDescription(sc.nextLine());

				System.out.print("Id of the user who received income> ");
				incomeRequest.setUserReceivedIncomeId(sc.nextLong());

				System.out.print("Id of the other users who participated in creating the income> ");
				while(sc.hasNextLong()){
					incomeRequest.addUsersParticipatedInIncomeId(sc.nextLong());
				}

				System.out.println(controller.addIncome(incomeRequest));
			} else if(command.equals(ADD_EXPENSE)){
				ExpenseRequest expenseRequest = new ExpenseRequest();

				System.out.print("Expense amount> ");
				expenseRequest.setAmount(sc.nextDouble());
				sc.nextLine();

				System.out.print("Expense description> ");
				expenseRequest.setDescription(sc.nextLine());

				System.out.print("Id of the user who payed expense> ");
				expenseRequest.setUserReceivedExpenseId(sc.nextLong());

				System.out.print("Id of the other users who participated in creating the expense> ");
				while(sc.hasNextLong()){
					expenseRequest.addUsersParticipatedInExpenseId(sc.nextLong());
				}

				System.out.println(controller.addExpense(expenseRequest));
			} else if (command.equals(ADD_INTERCHANGE)){
				InterchangeRequest interchangeRequest = new InterchangeRequest();

				System.out.print("Interchange amount> ");
				interchangeRequest.setAmount(sc.nextDouble());
				sc.nextLine();

				System.out.print("Interchange description> ");
				interchangeRequest.setDescription(sc.nextLine());

				System.out.print("Id of the person who gave the money> ");
				interchangeRequest.setUserGiverId(sc.nextLong());

				System.out.print("Id of the person who received the money> ");
				interchangeRequest.setUserReceiverId(sc.nextLong());

				System.out.println(controller.addInterchange(interchangeRequest));
			} else {
				System.out.println("Wrong command input, please use the correct command.");
				System.out.println("Commands: " + ADD_USER + ", " + GET_USER + ", " + GET_ALL_USERS + ", " + SHOW_BALANCE +
						", " + ADD_INCOME + ", " + ADD_EXPENSE + ", " + ADD_INTERCHANGE);
			}
		}
	}

}

