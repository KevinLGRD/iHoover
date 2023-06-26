package enums;

public enum Deplacement {
    GAUCHE("G"), DROITE("D"), AVANCER("A");

    private final String instruction;
    Deplacement(String instruction) {
        this.instruction = instruction;
    }
    public String getInstruction() {
        return instruction;
    }

    public static Deplacement instructionVersDeplacement(String instruction) {
        for (Deplacement deplacement : Deplacement.values()) {
            if (deplacement.getInstruction().equals(instruction)) {
                return deplacement;
            }
        }
        throw new IllegalArgumentException("Instruction invalide: " + instruction);
    }
}
