---
layout: page
title: Esercitazioni A.A. 2024/2025
permalink: /esercizi/AA24_25/
---

## {{page.title}}

{{site.baseurl}}

{% for folder in site.pages %}
{% if folder.dir contains AA24 %}
{{folder.dir}}
{% endif %}
{% endfor %}
