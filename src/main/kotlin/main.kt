import java.util.*

fun main(args: Array<String>) {

    val nbMaxEssai = 12
    var win: Boolean = false
    var nbEssai: Int = 1

    val random = Random()
    val min = 0
    val max = 10
    // Générer le tableau de valeurs à trouver
    var tabAtrouver  = IntArray(4) { random.nextInt(max - min) +  min }.asList()
    println(tabAtrouver)

/*    do {
        nbEssai++*/
        // saisie de l'utilisateur d'un nombre
        println("Veuillez entrer vos 4 propositions")

        val nb1 = readLine()!!.toInt()
        val nb2 = readLine()!!.toInt()
        val nb3 = readLine()!!.toInt()
        val nb4 = readLine()!!.toInt()

        // Générer tableau des réponses
        var tabReponse: MutableList<Int> = mutableListOf()
        tabReponse.add(nb1)
        tabReponse.add(nb2)
        tabReponse.add(nb3)
        tabReponse.add(nb4)

        var posOk = 0;
        var mauvaisePos = 0

        val bonnePosition = mutableSetOf<Int>()
        val mauvaisePosition = mutableSetOf<Int>()


        for (indice: Int in tabAtrouver.indices) {
            // On regarde si il a des chiffre à la bonne position
            if (tabAtrouver[indice] == tabReponse[indice]) {
                posOk++
                bonnePosition.add(indice) //
                if (posOk == 4) { win = true}
            }
        }
        if (!win) { print("nombre d'élément à la bonne place : $posOk") }

        for (i in tabAtrouver.indices) { // POur chaque valeur de tabATrouver
            if (i !in bonnePosition) { // si il n'y a pas de bonne postition
                for (j in tabReponse.indices) { // pour chaque valeur de tabReponse
                    if (j !in bonnePosition && tabAtrouver[i] == tabReponse[j])
                        mauvaisePos++
                        mauvaisePosition.add(j)
                        if(mauvaisePos ==  0) { win = true}

                }
            }
        }
        if (!win) { print("element en mauvaise position : $mauvaisePos") }

        // Si les deux tableaux correspondent c'est gagné
        if(tabReponse.containsAll(tabAtrouver) && mauvaisePosition.isEmpty() ) {
            win = true
            println("Bravo, vous avez gagné en $nbEssai coup")
        }



  /*  } while (!win || nbEssai < nbMaxEssai)*/

}