package utilities.armor;

public class Armor {
        private String name;
        private int strength;
        private int health;
        private String rank;

        public Armor(String name, int strength, int health, String rank) throws Exception{
            this.name = name;
            this.strength  = strength;
            this.health = health;
            this.rank = rank;

            this.setDefensePower(rank);
        }

        private void setDefensePower(String rank) throws IllegalAccessException{
            int defense;
            switch (rank){
                case "E" -> defense = 15;
                case "D" -> defense = 30;
                case "C" -> defense = 50;
                case "B" -> defense = 70;
                case "A" -> defense = 100;
                case "S" ->  defense = 150;
                default -> throw new IllegalAccessException("Unexpected value "+ rank);
            }
            // max all health armor and defense special rank
            this.health += defense;
        }

        // get base armor defence from rank for compare weapon opponent
        public String getRankArmor(){
            return this.rank;
        }

        // getter
        public int getHealthArmor(){
            return this.health + this.strength + 15;
        }
}
