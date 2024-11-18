---
layout: page
title: Esercitazioni A.A. 2024/2025
permalink: /esercizi/AA24_25/
---

## {{page.title}}

{% for folder in site.pages %}
{% if folder.dir contains page.permalink %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
