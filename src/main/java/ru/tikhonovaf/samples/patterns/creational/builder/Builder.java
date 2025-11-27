package ru.tikhonovaf.samples.patterns.creational.builder;
class House {
    private String foundation;
    private String roof;
    private int rooms;

    private House() {}

    public static class Builder {
        private String foundation;
        private String roof;
        private int rooms;

        public Builder setFoundation(String foundation) { this.foundation = foundation; return this; }
        public Builder setRoof(String roof) { this.roof = roof; return this; }
        public Builder setRooms(int rooms) { this.rooms = rooms; return this; }

        public House build() {
            House house = new House();
            house.foundation = this.foundation;
            house.roof = this.roof;
            house.rooms = this.rooms;
            return house;
        }
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", roof=" + roof + ", rooms=" + rooms + "]";
    }

    public static void main(String[] args) {
        House house = new House.Builder()
                .setFoundation("Concrete")
                .setRoof("Tiles")
                .setRooms(4)
                .build();

        System.out.println(house);
    }
}
