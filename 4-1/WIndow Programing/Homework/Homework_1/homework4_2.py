import string;

value = { "var" : "lolrem ipsum"}

t = string.Template("""
Variable        : $var
Escape          : $$
Variable in text: ${var}iable
""");

print(t.substitute(value));

