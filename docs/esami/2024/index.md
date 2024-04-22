---
layout: page
title: Tracce d'esame
permalink: /esami/2024/
---

# Tracce d'esame 2024

{% for folder in site.pages %}
{% if folder.dir contains 2024 %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
