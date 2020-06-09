# Composite: Pietanza

Vogliamo realizzare un sistema per definire delle pietanze come composizione di ingredienti base (olio, farina, funghi...) e preparati (salsa, polpette, ragù...), dove un preparato può essere a sua volta composto da altri preparati o ingredienti.

Per ogni pietanza deve essere possibile visualizzare la lista completa di ingredienti e il calcolo delle calorie totali. Ad esempio:

```bash
# spaghetti aglio olio e peperoncino
        # spaghetti
                - 80g farina (364 kcal per 100g)
                - 5g sale (0 kcal per 100g)
                - 50g acqua (0 kcal per 100g)
        # condimento
                - 3g aglio (0 kcal per 100g)
                - 10g olio (884 kcal per 100g)
                - 1g peperoncino (0 kcal per 100g)
Calorie totali: 379
# spaghetti e basta
        # spaghetti
                - 80g farina (364 kcal per 100g)
                - 5g sale (0 kcal per 100g)
                - 50g acqua (0 kcal per 100g)
Calorie totali: 291
```

## Soluzione
![Diagramma degli Stati](uml/class_diagram.png)