package com.tap.sanika.demo;

/**
 * Hello world!
 *
 */
import java.sql.*;
import java.util.Scanner;

import com.tap.sanika.Repository.TflMentoringRepo;

public class App {
    public static void main(String[] args) throws Exception {
        TflMentoringRepo repo = new TflMentoringRepo();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-------------Menu----------------------");
            System.out.println("1.Add Topics");
            System.out.println("2.update existing topics");
            System.out.println("3.Delete existing topics");
            System.out.println("4.Display existing topics");
            System.out.println("5.Exit");

            System.out.println("\nEnter your choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("enter topicd id");
                    int topicId = sc.nextInt();
                    System.out.println("enter topic name");
                    String topicName = sc.next();
                    System.out.println("enter topic url");
                    String topicUrl = sc.next();
                    System.out.println("enter repository id");
                    int repoId = sc.nextInt();
                    if (repo.insert(topicId, topicName, topicUrl, repoId)) {
                        System.out.println("topic added");
                    } else {
                        System.out.println("something went wrong");
                    }
                }
                    break;

                case 2: {
                    System.out.println("enter topicd id");
                    int topicId = sc.nextInt();
                    System.out.println("enter topic name");
                    String topicName = sc.next();
                    System.out.println("enter topic url");
                    String topicUrl = sc.next();
                    System.out.println("enter repository id");
                    int repoId = sc.nextInt();
                    if (repo.update(topicId, topicName, topicUrl, repoId)) {
                        System.out.println("topic updated");
                    } else {
                        System.out.println("something went wrong");
                    }
                }
                    break;
                case 3: {
                    System.out.println("enter topicd id");
                    int topicId = sc.nextInt();

                    if (repo.delete(topicId)) {
                        System.out.println("topic deleted");
                    } else {
                        System.out.println("something went wrong");
                    }
                }
                    break;

                case 4: {
                   repo.getAll();
                   break;
                }

                case 5: {
                    System.out.println("exiting....");
                    System.exit(0);
                }
                    break;
                default:
                    break;
            }

        } while (choice != 5);
    }
}