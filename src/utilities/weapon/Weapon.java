package utilities.weapon;

public class Weapon {
        private String name;
        private int attackPower;
        private String rank;

        /*
        * attack power is original power from weapon
        * rank weapon, summary attack power while rank weapon highly
        * */

        public Weapon(String name, int attackPower, String rank) throws Exception{
            this.attackPower = attackPower;
            this.name = name;
            this.rank = rank;

            this.setAttackPower(rank);
        }

        // special damage calculating with rank
        private void setAttackPower(String rank) throws IllegalAccessException{
            int damage;
            switch (rank){
                case "E" -> damage = 5;
                case "D" -> damage = 15;
                case "C" -> damage = 30;
                case "B" -> damage = 50;
                case "A" -> damage = 80;
                case "S" ->  damage = 100;
                default -> throw new IllegalAccessException("Unexpected value "+ rank);
            }
            this.attackPower += damage;
        }

        public String getRankWeapon(){
            return this.rank;
        }

        public int getAttackPower(){
            return this.attackPower;
        }
}
