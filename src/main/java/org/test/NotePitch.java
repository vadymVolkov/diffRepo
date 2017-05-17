package org.test;

public class NotePitch {
    private String step;
    private String alter;
    private String octave;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    public String getOctave() {
        return octave;
    }

    public void setOctave(String octave) {
        this.octave = octave;
    }

    @Override
    public String toString() {
        return "NotePitch{" +
                "step='" + step + '\'' +
                ", alter='" + alter + '\'' +
                ", octave='" + octave + '\'' +
                '}';
    }
}
