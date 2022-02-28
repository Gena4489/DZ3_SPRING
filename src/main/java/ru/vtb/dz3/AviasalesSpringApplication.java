package ru.vtb.dz3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtb.dz3.model.Premiere;
import ru.vtb.dz3.services.PremiereService;


@SpringBootApplication
public class AviasalesSpringApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AviasalesSpringApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        //Добавили 2-е премьеры
        premiereService.addPremiere(new Premiere("Аида", "Опера Джузеппе Верди в 4 действиях", 20, 100));
        premiereService.addPremiere(new Premiere("Трубадур", "Опера Джузеппе Верди в 4 действиях", 15, 50));

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Добавлена новая премьера
        premiereService.addPremiere(new Premiere("Евгений Онегин",  "Опера Петра Чайковский по поэме А.С. Пушкина «Полтава» (1883)", 14, 30));

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Удалена премьера
        premiereService.deletePremiere("Аида");
        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Куплено 5 билетов на премьеру
        if (!premiereService.buyTickets("Евгений Онегин", 5)) {
            System.out.println("Все билеты на премьру \"Евгений Онегин\" выкуплены");
        }

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");
    }

}
