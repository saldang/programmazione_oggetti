---
layout: page
title: Esercitazioni A.A. 2025/2026
permalink: /esercizi/AA25_26/
---

## {{page.title}}

{% for folder in site.pages %}
{% if folder.dir contains page.permalink %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
