package org.example;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Main {
    public static void main(String[] args) {
// Путь к csv файлу
        String csvFilePath = "foreign_names.csv";

// Создание списка для хранения людей
        List<Person> people = new ArrayList<>();

        try {
// Создание объекта CSVReader для чтения данных из csv файла
            CSVReader reader = new CSVReader(new FileReader(csvFilePath));

// Чтение строк из csv файла
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
// Создание нового объекта Person для каждой строки
                Person person = new Person();

// Установка значений полей объекта Person из считанных данных

                person.setId(Integer.parseInt(nextLine[0]));
                person.setName(nextLine[1]);
                person.setGender(nextLine[2]);
                person.setDepartment(new Department(Integer.parseInt(nextLine[3]), nextLine[4]));
                person.setSalary(Double.parseDouble(nextLine[5]));
                person.setBirthday(nextLine[6]);

// Добавление объекта Person в список
                people.add(person);
            }

// Закрытие CSVReader
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

// Вывод списка людей
        for (Person person : people) {
            System.out.println(person);
        }
    }


    class Person {
        private int id;
        private String name;
        private String gender;
        private Department department;
        private double salary;
        private String birthday;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }


        @Override
        public String toString() {
            return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", salary="
                    + salary + ", birthday=" + birthday + "]";
        }
    }

    class Department {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Department [id=" + id + ", name=" + name + "]";
        }
    }
}