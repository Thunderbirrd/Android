package com.example.android;

public class Story {
    private Situation start_story;
    public Situation current_situation;

    Story() {
        start_story = new Situation(
                "начало",
                "Только вы начали работать и тут же удача! Вы нашли команду и вам надо только придумать идею. \n"
                        + "(1) приложение знакомств с ИИ\n"
                        + "(2) приложение для тренировок\n"
                        + "(3) игра для VR ",
                3, 0, 0, 0);
        start_story.direction[0] = new Situation(
                "Провал",
                "Ваша команда слишком глупа, чтобы сделать это - вы проиграли!",
                0, 0, 0, -10);
        start_story.direction[1] = new Situation(
                "Победа",
                "Вы победили! Поздравляем!",
                0, 60, 100, 20);
        start_story.direction[2] = new Situation(
                "Чуть чуть не хватило",
                "Вам не хватило совсем чуть-чуть, победа была близка!",
                0, 50,
                50, 15);
        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}
