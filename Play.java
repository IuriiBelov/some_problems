import java.util.ArrayList;
import java.util.List;

public class Play {
    static class Role {
        String roleName;

        List<String> strings;

        Role(String roleName, String string) {
            this.roleName = roleName;
            this.strings = new ArrayList<>();
            this.strings.add(string);
        }
    }

    public static void main(String[] args) {
        String [] roleNames = {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };
        String [] scenario = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(groupScenarioByRoles(roleNames, scenario));
    }

    private static String groupScenarioByRoles(String[] roleNames, String[] scenario) {
        List<Role> roles = new ArrayList<>();

        for (int i = 0; i < scenario.length; ++i) {
            String roleName = getRoleName(roleNames, scenario[i]);

            String string = (i + 1) + ") " + scenario[i].substring(roleName.length() + 2);

            addNewString(roles, roleName, string);
        }

        return getText(roles);
    }

    private static String getRoleName(String[] roleNames, String string) {
        for (String rn : roleNames) {
            if (string.indexOf(rn) == 0) {
                return rn;
            }
        }
        return null;
    }

    private static void addNewString(List<Role> roles, String roleName, String string) {
        for (Role role : roles) {
            if (role.roleName.equals(roleName)) {
                role.strings.add(string);
                return;
            }
        }
        Role role = new Role(roleName, string);
        roles.add(role);
    }

    private static String getText(List<Role> roles) {
        StringBuilder text = new StringBuilder();

        for (Role role : roles) {
            text.append(role.roleName);
            text.append(":\n");

            for (String string : role.strings) {
                text.append(string);
                text.append("\n");
            }

            text.append("\n");
        }

        return new String(text);
    }
}
