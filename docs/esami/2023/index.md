---
layout: post
title: Tracce d'esame
---

# Tracce d'esame 2023

{% for folder in site.pages %}
{% if folder.dir contains 'esami/2023' %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
