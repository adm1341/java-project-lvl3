### Валидатор данных :
[![Actions Status](https://github.com/adm1341/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/adm1341/java-project-lvl3/actions)
[![Java CI](https://github.com/adm1341/java-project-lvl3/actions/workflows/main.yml/badge.svg)](https://github.com/adm1341/java-project-lvl3/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/adm1341/java-project-lvl3/maintainability"><img src="https://api.codeclimate.com/v1/badges/0a9f223dc5285f500466/maintainability" /></a>
<a href="https://codeclimate.com/github/adm1341/java-project-lvl3/test_coverage"><img src="https://api.codeclimate.com/v1/badges/0a9f223dc5285f500466/test_coverage" /></a>
<br>
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями. За основу для проекта взята библиотека yup.

Пример использования:
<code><br>
import hexlet.code.Validator;<br>
import hexlet.code.schemas.StringSchema;<br>
import hexlet.code.schemas.NumberSchema;<br>
import hexlet.code.schemas.MapSchema;<br>
import hexlet.code.schemas.BaseSchema;<br>

Validator v = new Validator();<br>

// строки<br>
StringSchema schema = v.string().required();<br>

schema.isValid("what does the fox say"); // true<br>
schema.isValid(""); // false<br>

// числа<br>
NumberSchema schema = v.number().required().positive();<br>

schema.isValid(-10); // false<br>
schema.isValid(10); // true<br>

// объект Map с поддержкой проверки структуры<br>
Map<String, BaseSchema> schemas = new HashMap<>();<br>
schemas.put("name", v.string().required());<br>
schemas.put("age", v.number().positive());<br>

MapSchema schema = v.map().sizeof(2).shape(schemas);<br>

Map<String, Object> human1 = new HashMap<>();<br>
human1.put("name", "Kolya");<br>
human1.put("age", 100);<br>
schema.isValid(human1); // true<br>

Map<String, Object> human2 = new HashMap<>();<br>
human2.put("name", "");<br>
human2.put("age", null);<br>
schema.isValid(human1); // false<br>
</code>
<br>
Более подробное описание на https://ru.hexlet.io/programs/java/projects/78