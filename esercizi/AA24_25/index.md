---
layout: page
title: Esercitazioni A.A. 2024/2025
permalink: /esercizi/AA24_25/
---

## {{page.title}}

site.baseurl
folder.url
folder.name

{% for folder in site.pages %}
{% if folder.dir contains AA24_25 %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}}{{folder.name}})
  {% endif %}
  {% endif %}
  {% endfor %}
