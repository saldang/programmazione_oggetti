---
layout: page
title: Tracce 2024
permalink: /esami/2024/
---

## {{page.title}}

{% for folder in site.pages %}
{% if folder.dir contains 2024 %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
