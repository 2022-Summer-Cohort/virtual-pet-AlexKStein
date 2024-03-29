package virtual_pet_amok;

import java.util.Scanner;

public class VirtualPetApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quitGame = false;
        boolean adopt = false;
        boolean commandLoopy;
        VirtualPet adoptedPet = null;
        VirtualPetShelter shelter = new VirtualPetShelter();

        System.out.println("Original ASCII Art by lgbeard");
        System.out.print(
                "                         ,_______________________\n" +
                "            ___________.'     `-           '_.'\\/`.\n" +
                "          .'       _  .' _______   -.__ .- .'\\.'`./`.\n" +
                "        .'     _   _.'      _   _        .'\\.' `._`./`.\n" +
                "      .' _       _.' __          __    .'\\.'  ___`._`./`.\n" +
                "    .'        _ .'   _____           .'\\.'         `._`./`.\n" +
                "  .'  _  _    .'       ______      .'\\.'  __         `._`./`.\n" +
                ".'`--...__ _.'            ______ .'\\.'   Pounce's __   `._`./`.\n" +
                " `--...__ .'   ____            .'\\.'       Play _        `._`./`.\n" +
                " |      .`--...__            .'\\.'     _     Palace    ____`._`./`.\n" +
                " | /`-._ `--...__`--...___ .'\\.'              _______       _`._`./`.\n" +
                " | |    ||       `--...____\\.'     _     _  .'      .`.        `._`./\n" +
                " | |    || /`-._             |            .'      .'   `.     _ |\n" +
                " | |    || |    |  /`-.__  ._|____       /      .'       `.     |\n" +
                " | |    || |    |  |     |   | _      _ /      /   .---.  `\\    |\n" +
                " | `--._/| |    |  |U*ᴥ*U|`- |         /`--.._/   /     \\  ' _  |\n" +
                " | `-.   | |    |  |^*ᴥ*^|   |       __|      |_  |`-   |  |  _ |\n" +
                " |    `-.| |    |  |U◕ᴥ◕U|   |  ___  _ |  __  | __| \\`- |  |    |\n" +
                " '-._    | `--._/  |^•ᴥ•^|   |      __ |      |   | |`- |  | _  |\n" +
                "     `-._| `--.    `--.__/   |  ___    | _    |   | |`- |  |   '|\n" +
                "         |      `--._        |       _ |    ' |   |O|`- | _| _  |\n" +
                "         '--._         `--._ |         | _    |_ \"| |`- |. |  __|\n" +
                "              `--._          |       __|      |   | |`- |. | __ |\n" +
                "                   `--._     |__       |   _  |\"  | |`- |  |___ |\n" +
                "                        `--._|_________|_     | _ |  `- |_ |____|\n" +
                "                                         '--._|___|     |__|\n");

        //Welcome! Shelter & pet intros
        OrganicDog frodo = new OrganicDog("Frodo", "organic Dog", "Bark", 0, 100, 0,false,  0, true, 0, false);
        RobotDog bilbo = new RobotDog("Bilbo", "robot dog", "zzWoOfzz", 0,100,0,false,  0, false, false);
        OrganicCat samwise = new OrganicCat("Samwise", "organic cat", "meow", 0, 100, 0, false, 0, true, 0, false, 0);
        RobotCat gandalf = new RobotCat("Gandalf", "robot cat", "MeowZzza", 0, 100, 0, false,  0, false,false);
        //admit starting pets
        shelter.admitRD(bilbo); shelter.admitOD(frodo); shelter.admitOC(samwise); shelter.admitRC(gandalf);
        System.out.println("Welcome to Pounce's Play Palace & Pet Shelter! There are many things you can do with your robotic and organic pets, but first lets meet everyone:");
        shelter.meetAll();
        System.out.println("Please note that oil levels have been replaced with liquor for robots, taking after the deeply scientific works of Futurama.");
        System.out.println(" ");
        System.out.println("Shelter Commands:");
        System.out.println("All pets: 'play', 'meet', 'hydrate', 'recharge', 'adopt' or 'admit' a pet, and check everyone's 'status' ");
        System.out.println("Organic pets: 'feed', 'clean' their rooms or 'nap' for a quick snooze.");
        System.out.println("Robot pets: 'charge' and 'maintenance' ");
        System.out.println("Just the Doggos: 'walk' all the dogs (robots and organics)");
//Shelter loop
        while (!quitGame){

            System.out.println("What would you like to do? Type 'help' for a list of commands or 'quit' anytime to exit.");
            String userInput = input.nextLine();
            switch (userInput.toLowerCase()){
                case "quit":
                    quitGame = true;
                    break;
                case "help":
                    System.out.println("All pets: 'play', 'meet', 'hydrate', 'recharge', 'adopt' or 'admit' a pet, and check everyone's 'status' ");
                    System.out.println("Organic pets: 'feed', 'clean' their rooms or 'nap' for a quick snooze.");
                    System.out.println("Robot pets: 'charge' and 'maintenance' ");
                    System.out.println("Just the Doggos: 'walk' all the dogs (robots and organics)");
                    System.out.println("Hint: try '(command) all' for a quick way to interact with all possible pets");
                    break;
                case "meet":
                    shelter.meetAll();
                    shelter.tick();
                    break;
                case "meet all":
                    shelter.meetAll();
                    shelter.tick();
                    break;
                case "status":
                    shelter.statusAll();
                    break;
                case "status all":
                    shelter.statusAll();
                    break;
                case "play all":
                    System.out.println("Wagging tails and Happy meows!");
                    shelter.playAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "play":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to play with all the pets, or their name to play with just one.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            System.out.println("Wagging tails and Happy meows!");
                            shelter.playAll();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).play();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "feed all":
                    shelter.feedAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "feed":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to feed all organic pets, or their name to feed just one.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.feedAll();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).feed();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "walk all":
                    shelter.walkDogs();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "walk":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' walk all the dogs or the name of the pet to take on a solo walk.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.walkDogs();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            if (shelter.petFinder(userInput) instanceof Walking) {
                                ((Walking) shelter.petFinder(userInput)).walk();
                            }
                            else{
                                System.out.println("Woof -_-. You tried to take a cat on a walk, which clearly didn't work. ");
                            }
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "recharge":
                    shelter.chargeAndNap();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "nap all":
                    shelter.napTime();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "nap":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to nap with all organic pets or a pet's name to let that one nap.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.napTime();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).nap();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "charge all":
                    shelter.chargeAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "charge":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to charge up all robits, or their name for a single charger.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.chargeAll();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).charge();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "maintenance all":
                    shelter.maintainAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "maintenance":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to fix up all the robots, or their name to maintain just one pet.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.maintainAll();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).maintain();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "hydrate all":
                    shelter.hydrateAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "hydrate":
                    commandLoopy = true;
                    while (commandLoopy){
                        System.out.println("Type 'all' to give all the pets a drink, or their name to hydrate just one.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")){
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.hydrateAll();
                            commandLoopy = false;
                        }
                        else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).hydrate();
                            commandLoopy = false;
                        }
                        else{
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "clean all":
                    shelter.cleanAll();
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "clean":
                    commandLoopy = true;
                    while (commandLoopy) {
                        System.out.println("Type 'all' to clean the organic pet rooms, or the pet's name to clean up after just one.");
                        userInput = input.nextLine();
                        if (userInput.equalsIgnoreCase("quit")) {
                            quitGame = true;
                            break;
                        }
                        if (userInput.equalsIgnoreCase("all")) {
                            shelter.cleanAll();
                            commandLoopy = false;
                        } else if (shelter.isPetFound(userInput)) {
                            shelter.petFinder(userInput).cleanRoom();
                            commandLoopy = false;
                        } else {
                            shelter.wrongCommand();
                        }
                    }
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "admit":
                    System.out.println("What is your pet's name?");
                    String newPetName = input.nextLine();
                    System.out.println("And what type of animal are they (ie. 'robot dog' or 'organic cat'");
                    String newPetType = input.nextLine();
                    if (newPetType.equalsIgnoreCase("robot dog")){
                            shelter.admitRD(new RobotDog(newPetName, newPetType, "Woofz", 0, 100, 0, false,  0, false, false));
                        }
                    else if (newPetType.equalsIgnoreCase("robot cat")) {
                        shelter.admitRC(new RobotCat(newPetName, newPetType, "MeowzZa", 0, 100, 0, false, 0, false, false));
                        }
                    else if(newPetType.equalsIgnoreCase("organic dog")){
                        shelter.admitOD(new OrganicDog(newPetName, newPetType, "Woof", 0, 100, 0, false,  0, true, 0, false));
                    }
                    else if (newPetType.equalsIgnoreCase("organic cat")){
                        shelter.admitOC(new OrganicCat(newPetName, newPetType, "Meow", 0, 100, 0, false, 0, true, 0, false, 0));
                    }
                    else {
                        System.out.println("Pet type not recognized. Type 'admit' to try again or...");
                    }
                    System.out.println("Welcome to Pounce's Play Palace, " + newPetName);
                    shelter.tick();
                    shelter.statusAll();
                    break;
                case "adopt":
                    System.out.println("Please type the name of the pet you would like to adopt:");
                    userInput = input.nextLine();
                    if (userInput.equalsIgnoreCase("quit")){
                        quitGame = true;
                        break;
                    }
                    else{
                        for(VirtualPet thisPet: shelter.getPetShelter()){
                            if (thisPet.getTrueName().equalsIgnoreCase(userInput)){
                                adoptedPet = thisPet;
                                System.out.println("Type 'leave' to take " + thisPet.getName() + " to their new fur-ever home, or 'stay' to stay at the shelter");
                                userInput = input.nextLine();
                                if(userInput.equalsIgnoreCase("leave")) {
                                    System.out.println("Thank you for adopting " + thisPet.getName() + " and visiting Pounce's Play Palace! Cheers.");
                                    adopt = true;
                                    quitGame=true;
                                    break;
                                }
                                else if(userInput.equalsIgnoreCase("stay")){
                                    System.out.println("Thank you for adopting " + thisPet.getName());
                                    shelter.adoptPet(adoptedPet);
                                    shelter.tick();
                                    shelter.statusAll();
                                    break;
                                }
                                else{
                                    System.out.println("Command not recognized, so you stay here! Thanks for adopting " + thisPet.getName());
                                    shelter.adoptPet(adoptedPet);
                                    shelter.tick();
                                    shelter.statusAll();
                                    break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    shelter.wrongCommand();
            }
            if(shelter.getPetShelter().size()<=0){
                System.out.println("Wow! You've adopted all the pets! Even the weird ones <3");
                quitGame = true;
            }
        }
        if (!adopt){
            System.out.println("Thanks for visiting Pounce's Pet Palace, have a great day!");
        }
//single pet adoption loops
        //organic dog
        if (adopt && adoptedPet.getType().equalsIgnoreCase("Organic Dog")){
            System.out.println("Welcome to your new fur-ever home, " + adoptedPet.getName() +"!");
            adoptedPet.help();
            while(adopt) {
                System.out.println("What would you like? Type 'help' for a list of activities or 'quit' to quit.");
                String userInput = input.nextLine();
                switch (userInput.toLowerCase()) {
                    case "quit":
                        adopt = false;
                        break;
                    case "help":
                        adoptedPet.help();
                        break;
                    case "play":
                        System.out.println(adoptedPet.getName() + "'s tail is wagging and happily plays with you. " + adoptedPet.getNoise() + "!");
                        adoptedPet.play();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "feed":
                        adoptedPet.feed();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "nap":
                        adoptedPet.nap();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "walk":
                        ((Walking)adoptedPet).walk();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "hydrate":
                        adoptedPet.hydrate();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "clean":
                        adoptedPet.cleanRoom();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "meet":
                        adoptedPet.meet();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "status":
                        adoptedPet.status();
                        break;
                    default:
                        adoptedPet.wrongCommand();
                        break;
                }
            }
        }
        //Robot Dog
        if (adopt && adoptedPet.getType().equalsIgnoreCase("Robot Dog")) {
            System.out.println("Welcome to your new fur-ever home, " + adoptedPet.getName() + "!");
            adoptedPet.help();
            while (adopt) {
                System.out.println("What would you like? Type 'help' for a list of activities or 'quit' to quit.");
                String userInput = input.nextLine();
                switch (userInput.toLowerCase()) {
                    case "quit":
                        adopt = false;
                        break;
                    case "help":
                        adoptedPet.help();
                        break;
                    case "play":
                        System.out.println(adoptedPet.getName() + "'s lil' tail is wagging & is so excited to play with you! " +adoptedPet.getNoise());
                        adoptedPet.play();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "hydrate":
                        adoptedPet.hydrate();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "walk":
                        ((Walking) adoptedPet).walk();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "charge":
                        adoptedPet.charge();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "maintain":
                        adoptedPet.maintain();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "meet":
                        adoptedPet.meet();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "status":
                        adoptedPet.status();
                        break;
                    default:
                        adoptedPet.wrongCommand();
                        break;
                }
            }
        }
        //Organic Cat
        if (adopt && adoptedPet.getType().equalsIgnoreCase("Organic cat")){
            System.out.println("Welcome to your new fur-ever home, " + adoptedPet.getName() +"!");
            adoptedPet.help();
            while(adopt) {
                System.out.println("What would you like? Type 'help' for a list of activities or 'quit' to quit.");
                String userInput = input.nextLine();
                switch (userInput.toLowerCase()) {
                    case "quit":
                        adopt = false;
                        break;
                    case "help":
                        adoptedPet.help();
                        break;
                    case "play":
                        System.out.println("*" + adoptedPet.getNoise() + "* " + adoptedPet.getName() + " happily plays with you :3");
                        adoptedPet.play();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "feed":
                        adoptedPet.feed();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "nap":
                        adoptedPet.nap();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "hydrate":
                        adoptedPet.hydrate();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "clean":
                        adoptedPet.cleanRoom();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "meet":
                        adoptedPet.meet();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "status":
                        adoptedPet.status();
                        break;
                    default:
                        adoptedPet.wrongCommand();
                        break;
                }
            }
        }
        //Robot Cat
        if (adopt && adoptedPet.getType().equalsIgnoreCase("robot cat")) {
            System.out.println("Welcome to your new fur-ever home, " + adoptedPet.getName() + "!");
            adoptedPet.help();
            while (adopt) {
                System.out.println("What would you like? Type 'help' for a list of activities or 'quit' to quit.");
                String userInput = input.nextLine();
                switch (userInput.toLowerCase()) {
                    case "quit":
                        adopt = false;
                        break;
                    case "help":
                        adoptedPet.help();
                        break;
                    case "play":
                        System.out.println(adoptedPet.getName() + " happily plays with you :3");
                        adoptedPet.play();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "hydrate":
                        adoptedPet.hydrate();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "charge":
                        adoptedPet.charge();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "maintain":
                        adoptedPet.maintain();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "meet":
                        adoptedPet.meet();
                        adoptedPet.tick();
                        adoptedPet.status();
                        break;
                    case "status":
                        adoptedPet.status();
                        break;
                    default:
                        adoptedPet.wrongCommand();
                        break;
                }
            }
        }
    }
}

