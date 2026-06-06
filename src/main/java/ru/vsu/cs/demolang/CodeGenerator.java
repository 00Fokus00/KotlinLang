package ru.vsu.cs.demolang;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static class CodeLabel {
        private final String prefix;
        Integer index = null;           // заполняется в getCode()

        public CodeLabel(String prefix) {
            this.prefix = prefix;
        }

        public CodeLabel() {
            this("L");
        }

        @Override
        public String toString() {
            return index == null ? prefix + "_?" : prefix + "_" + index;
        }
    }

    private static class CodeLine {
        final String instruction; // null если строка — только метка
        final Object[] params;      // аргументы инструкции
        final CodeLabel label;       // метка перед строкой (может быть null)
        final String indent;      // отступ, зафиксированный в момент add()

        CodeLine(String instruction, Object[] params, CodeLabel label, String indent) {
            this.instruction = instruction;
            this.params = params;
            this.label = label;
            this.indent = indent;
        }

        String render() {
            StringBuilder sb = new StringBuilder();

            if (label != null) {
                // Метка печатается с меньшим отступом — "выступает" влево
                String labelIndent = indent.length() >= 2 ? indent.substring(2) : "";
                sb.append(labelIndent).append(label).append(":");
                if (instruction != null) sb.append("  ");
            } else {
                sb.append(indent);
            }

            if (instruction != null) {
                sb.append(instruction);
                for (Object p : params) sb.append(" ").append(p);
            }

            return sb.toString();
        }
    }

    private final List<CodeLine> lines = new ArrayList<>();
    private String indent = "  "; // начальный отступ

    public void add(String instruction) {
        addLine(instruction, new Object[0], null);
    }

    public void add(String instruction, Object param) {
        addLine(instruction, new Object[]{param}, null);
    }

    public void add(String instruction, Object p1, Object p2) {
        addLine(instruction, new Object[]{p1, p2}, null);
    }

    public void add(CodeLabel label) {
        addLine(null, new Object[0], label);
    }


    private void addLine(String instruction, Object[] params, CodeLabel label) {
        // Закрывающая скобка уменьшает отступ до добавления строки
        if ("}".equals(instruction)) {
            if (indent.length() >= 2) indent = indent.substring(2);
        }

        lines.add(new CodeLine(instruction, params, label, indent));

        // Открывающая скобка увеличивает отступ после добавления строки
        if ("{".equals(instruction)) {
            indent = indent + "  ";
        }
    }

    public List<String> getCode() {
        int index = 0;
        for (CodeLine cl : lines) {
            if (cl.label != null) cl.label.index = index++;
        }
        List<String> result = new ArrayList<>();
        for (CodeLine cl : lines) result.add(cl.render());
        return result;
    }
}