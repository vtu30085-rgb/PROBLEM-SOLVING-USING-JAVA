import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(king, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children
            .computeIfAbsent(parentName, k -> new ArrayList<>())
            .add(childName);

        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();

        dfs(king, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person if they are alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children in birth order
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}
:::

## How it works

Suppose the family tree is:

```text
king
├── Alice
│   ├── Bob
│   └── Diana
└── Charlie
    └── Eve
