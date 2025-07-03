import java.util.Scanner;

public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testShowViewTodoList();
    }

    /**
     * menampilkan todolist
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodolist() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar Mmebuat Aplikasi Todolist";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodolist(String todo) {
        // 2. cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // 3. Jika penuh kita merubah ukuran array menjadi 2 kali lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // 1. Tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;

            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodolist("Contoh todo ke." + i);

        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodolist(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodolist("Satu ");
        addTodolist("Dua ");
        addTodolist("Tiga ");
        addTodolist("Empat ");
        addTodolist("Lima ");

        var result = removeTodolist(20);
        System.out.println(result);
        result = removeTodolist(7);
        System.out.println(result);
        result = removeTodolist(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * Mmebuat input data
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama ");
        System.out.println("Hi " + name);

        var channel = input("Channel ");
        System.out.println("Channel Kamu Adalah " + channel);
    }

    /**
     * menampilkan tampilan utama todolist
     */
    public static void viewShowTodolist() {
        System.out.println("==== TODOLIST ==== ");
        while (true) {

            showTodoList();

            System.out.println("===== MENU ==== ");
            System.out.println("1. Tambah ");
            System.out.println("2. Hapus ");
            System.out.println("X. Keluar ");

            var inputan = input("Pilih ");

            //inputan.equals diperuntukan komparasi String
            if (inputan.equals("1")) {
                viewAddTodolist();
            } else if (inputan.equals("2")) {
                viewRemoveTodolist();
            } else if (inputan.equals("X")) {
                break;
            } else {
                System.out.println("Pilihan Tidak Dapat Dimengerti ");
            }
        }
    }

    public static void testShowViewTodoList() {
        addTodolist("Satu");
        addTodolist("Dua");
        addTodolist("Tiga");
        addTodolist("Empat");
        addTodolist("Lima");
        viewShowTodolist();
    }

    /**
     * Menampilkan tampilan tambah dari todolist
     */
    public static void viewAddTodolist() {

    }

    /**
     * Menampilkan tampilan hapus dari todolist
     */
    public static void viewRemoveTodolist() {

    }
}
