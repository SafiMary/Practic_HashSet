
import java.util.HashSet;
import java.util.Scanner;
import java.lang.String;
import java.util.Iterator;

public class User {
        private String name;
        private  String surname;
        private  String email;
        private  int password;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName(){return name;}
    public HashSet<User> people = new HashSet<User>();//для хранения всех пользователей
    public User(){}

        public User(String name,String surname,String email,int password){
            this.name=name;
            this.surname = surname;
            this.email = email;
            this.password = password;
        }

        void Registrashion(){
            Scanner in = new Scanner(System.in);
            System.out.print("Для регистрации введите команду reg"+"\n"+ "Для входа введите команду enter"+"\n"+
                    "Для выхода из меню введите &"+"\n");
            boolean cheaker = true;
            while (cheaker) {
            String str = in.nextLine();
            switch (str) {
                case "reg":
                    System.out.print("Введите имя: ");
                    String name = in.nextLine();
                    System.out.print("Введите фамилию: ");
                    String surname = in.nextLine();
                    System.out.print("Введите email: ");
                    String email = in.nextLine();
                    System.out.print("Введите пароль: ");
                    int password = in.nextInt();
                    User user = new User(name,surname,email,password);
                    AddUser(user);
                    break;
                case "enter":
                    EnterUser();
                    break;
                case "&":
                    cheaker = false; // выход из меню
                    System.out.println("Вы вышли из меню");
                    break;
                default:
                    break;
            }
        }
    }
    void AddUser(User user){
        if(people.contains(user)){
            System.out.print("Такой пользователь уже зарегистрирован!"+"\n");
            EnterUser();
        }
            else people.add(user);
            System.out.print("Новый пользователь: " + user.name+ " добавлен"+"\n");

    }
    void EnterUser(){
        Scanner in = new Scanner(System.in);
        System.out.print("Для входа  введите данные "+"\n");
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = in.nextLine();
        System.out.print("Введите email: ");
        String email = in.nextLine();
        System.out.print("Введите пароль: ");
        int password = in.nextInt();
        User user = new User(name,surname,email,password);
            if(people.contains(user)){
                ShowUser();
            }
            else System.out.print("Такой пользователь не зарегистрирован"+"\n");
        }



void Remove(String name){
    for(User u : people){
        name = u.name;
    if(people.contains(u)){
            people.remove(u);
            System.out.print("Пользователь "+name+ " удален"+"\n");}
        }
    }


    void ShowUser(){
        System.out.print("Список всех пользователей:"+"\n");
        for(User u : people){
            System.out.println(u.getName());
        }
        Scanner p = new Scanner(System.in);
        System.out.print("Хотите удалить какого нибудь пользователя? Введите да или нет"+"\n");
        String str = p.nextLine();
        switch (str) {
            case "да":
                Scanner с = new Scanner(System.in);
                System.out.print("Введите имя пользователя"+"\n");
                String name = с.nextLine();
                Remove(name);
                break;
            case "нет":
                break;
        }
    }

    @Override
    public int hashCode()
    {
        int value;
        value = name.hashCode();
        return value;
    }

//если у объектов одинаковые значения,  результат будет true
    @Override
    public boolean equals(Object o) {
        if (o.getClass().equals(this.getClass())) {
            User u = (User) o;
            return u.name.equals(this.name) &&
                    u.password ==this.password &&
                    u.email.equals(this.email);//сравнивает поля объектов
        } else {
            return false;
        }
    }
}

