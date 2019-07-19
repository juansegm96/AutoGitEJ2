package ej2jsgm;

import PageObjects.CreateCustomer;
import PageObjects.CreateAccount;
import PageObjects.DeleteAccount;
import PageObjects.DeleteCustomer;
import PageObjects.login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class EJ2JSGMTest {

    static WebDriver driver = null;
    login log;
    CreateCustomer registro;
    CreateAccount cuenta;
    DeleteAccount borrarCuenta;
    DeleteCustomer borrarCliente;
    static String newCustomerID;
    static String newAccountID;

    public EJ2JSGMTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/index.php");
    }

    @Before
    public void setUp() {
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @After
    public void tearDown() {
    }

    /*
    Luego de examinar el flujo de cada caso de prueba, se llego a la conclusion
    de que los casos listados a continuacion PUEDEN mas no DEBEN ser ejecutados
    individualmente, ya que, si bien NetBeans permite hacerlo, todos los casos, 
    excepto el Login, dependen de un caso anterior, por lo que ejecutar un caso
    especifico podria significar errores de funcionamiento. Dado lo anterior,
    los casos de prueba no llamaran a otros casos de los cuales dependa, ya que
    de hacerlo, se repetirian procesos ya ejecutados en caso de ejecutar el 
    archivo completo.
     */
    
    @Test
    public void testLogin() {
        /*
        Se crean los datos de ingreso y se llama al driver para que ejecute el 
        Super-Metodo que contiene los Sub-Metodos necesarios para realizar el 
        ingreso. Luego se verifica que la cuenta desplegada en pagina es la 
        misma que ingresamos.
         */
        String userName = "mngr208434";
        String password = "qEzAsaj";
        log = new login(driver);
        log.loginApplication(userName, password);
        String mngrID = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText().substring(12);
        System.out.println(mngrID);
        assertEquals(userName, mngrID);
    }

    @Test
    public void testCreateCustomer() {
        /*
        Se crean los datos de registro de cliente y se llama al driver para que 
        ejecute el Super-Metodo que contiene los Sub-Metodos necesarios para 
        realizarlo. Luego se verifica que el cliente fue creado, y capturamos el
        ID que otorga el sistema.
         */
        String name = "Juanito";
        String date = "05051990";
        String address = "Test Street";
        String city = "Elpoli";
        String state = "Antioquia";
        String pin = "123456";
        String telephone = "321654987";
        String email = "juanito5@test.com";
        String password = "123456";
        registro = new CreateCustomer(driver);
        registro.Register(name, date, address, city, state, pin, telephone, email, password);
        newCustomerID = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
        System.out.println("New User ID: " + newCustomerID);
        boolean existe1 = driver.getPageSource().contains("Customer Registered Successfully!!!");
        assertEquals(true, existe1);
    }

    @Test
    public void TestCreateAccount() {
        /*
        Se crea el dato de deposito inicial y se llama al driver para que 
        ejecute el Super-Metodo que contiene los Sub-Metodos necesarios para 
        crear la cuenta, esto utilizando siempre el ID de Cliente capturado en 
        el Test anterior. Luego se verifica que la cuenta fue creada, y 
        capturamos el ID que otorga el sistema.
         */
        String initialDeposit = "150000";
        cuenta = new CreateAccount(driver);
        cuenta.accountRegister(newCustomerID, initialDeposit);
        newAccountID = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
        System.out.println("New Account ID: " + newAccountID);
        boolean existe1 = driver.getPageSource().contains("Account Generated Successfully!!!");
        assertEquals(true, existe1);
    }

    @Test
    public void testBorrarTodo() throws NoAlertPresentException, InterruptedException {
        /*
        Se llama a los driver para que ejecuten los metodos necesarios para la
        eliminacion de ambos, cuenta y cliente. Esto debe realizarse en orden, 
        primero cuenta, y luego cliente, ya que el sistema no permite eliminar
        clientes que tienen cuentas asiganas. Se verifica que ambos, cuenta y 
        cliente, fueron eliminados.
         */
        borrarCuenta = new DeleteAccount(driver);
        borrarCliente = new DeleteCustomer(driver);
        borrarCuenta.borrarCuenta(newAccountID);
        borrarCliente.borrarCustomer(newCustomerID);
        assertEquals(DeleteAccount.AlertA, "Account Deleted Sucessfully");
        assertEquals(DeleteCustomer.AlertC, "Customer deleted Successfully");
    }
}
