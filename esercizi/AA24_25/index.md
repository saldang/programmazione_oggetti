---
layout: page
title: Esercitazioni A.A. 2024/2025
permalink: /esercizi/AA24_25/
---

## {{page.title}}

{{site.baseurl}}

{% for folder in site.pages %}
{{folder.url}}
{{folder.name}}
{{folder.dir}}
{{folder.title}}
{{folder.url}}
{{site.baseurl}}
{{site.pages}}
{{site.pages.url}}
{{site.pages.name}}
{{site.pages.dir}}
{{site.pages.title}}
{{site.pages.url}}
{% if folder.dir contains AA24_25 %}
{% if folder.name != 'index.md' %}
{% if folder.dir contains AA24_25 %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
