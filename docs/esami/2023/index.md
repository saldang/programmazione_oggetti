---
layout: post
title: Tracce d'esame
date: 2023-04-22
---

# Tracce d'esame 2023

{% for folder in site.pages %}
{% if folder.dir contains 2023 %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
