package com.szkaminski.RPG.components.Functions;

        import com.szkaminski.RPG.characters.Hero;
        import com.szkaminski.RPG.components.MainLabel;
        import com.vaadin.flow.component.html.Div;
        import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Statistics extends Div {

    public Statistics(Hero hero) {
        this.setClassName("statistics-div");
        VerticalLayout vL = new VerticalLayout();
        if (hero != null) {
            vL.add(new MainLabel("Overall health: " + hero.getOverall_health().getReadableName()));
            vL.add(new MainLabel("Physical needs: Satisfied"));
            vL.add(new MainLabel("Sanity: Irritated"));
            vL.add(new MainLabel("Physicality: Long in the tooth"));
            vL.add(new MainLabel("Reputation: Awe-inspiring"));
            add(vL);
        }

        setVisible(false);
    }
}
