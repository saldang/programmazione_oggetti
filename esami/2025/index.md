---
layout: page
title: Tracce 2025
permalink: /esami/2025/
---

## {{page.title}}

{% for folder in site.pages %}
{% if folder.dir contains 2025 %}
{% if folder.name != 'index.md' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endif %}
  {% endfor %}
